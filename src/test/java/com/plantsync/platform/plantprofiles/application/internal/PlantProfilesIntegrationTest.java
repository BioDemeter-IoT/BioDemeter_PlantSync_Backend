package com.plantsync.platform.plantprofiles.application.internal;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.Plant;
import com.plantsync.platform.plantprofiles.domain.model.aggregates.PlantHistory;
import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantHistoryCommand;
import com.plantsync.platform.plantprofiles.domain.model.commands.UpdatePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantHistoriesByPlantIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantByIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.HumidityLevel;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantId;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantName;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.ProfileId;
import com.plantsync.platform.plantprofiles.domain.services.PlantCommandService;
import com.plantsync.platform.plantprofiles.domain.services.PlantHistoryCommandService;
import com.plantsync.platform.plantprofiles.domain.services.PlantHistoryQueryService;
import com.plantsync.platform.plantprofiles.domain.services.PlantQueryService;
import com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories.PlantHistoryRepository;
import com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories.PlantRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        "spring.profiles.active=test",
        "spring.datasource.url=jdbc:h2:mem:plantsync-plantprofiles-test;MODE=MySQL;DATABASE_TO_LOWER=TRUE;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;INIT=SET REFERENTIAL_INTEGRITY FALSE",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect",
        "spring.jpa.show-sql=false",
        "spring.flyway.enabled=false"
})
class PlantProfilesIntegrationTest {

    @Autowired
    private PlantCommandService plantCommandService;

    @Autowired
    private PlantQueryService plantQueryService;

    @Autowired
    private PlantHistoryCommandService plantHistoryCommandService;

    @Autowired
    private PlantHistoryQueryService plantHistoryQueryService;

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantHistoryRepository plantHistoryRepository;

    @BeforeEach
    void setUp() {
        plantHistoryRepository.deleteAll();
        plantRepository.deleteAll();
    }

    @Test
    @Transactional
    void createPlantShouldPersistPlantAndAllowQueryById() {
        // Arrange
        CreatePlantCommand command = new CreatePlantCommand(
                new PlantName("Monstera Deliciosa"),
                "Monstera",
                LocalDate.now(),
                HumidityLevel.MEDIA,
                LocalDate.now().plusDays(7),
                "http://image.url",
                true,
                new ProfileId(1L));

        // Act
        plantCommandService.handle(command);

        List<Plant> allPlants = plantRepository.findAll();
        assertFalse(allPlants.isEmpty());

        Long createdPlantId = allPlants.get(0).getId();
        Optional<Plant> queriedPlant = plantQueryService.handle(new GetPlantByIdQuery(createdPlantId));

        // Assert
        assertTrue(queriedPlant.isPresent());
        assertEquals("Monstera Deliciosa", queriedPlant.get().getName().value());
        assertEquals(HumidityLevel.MEDIA, queriedPlant.get().getHumidity());
    }

    @Test
    @Transactional
    void updatePlantShouldModifyPersistedPlant() {
        // Arrange
        CreatePlantCommand createCommand = new CreatePlantCommand(
                new PlantName("Cactus"),
                "Cactaceae",
                LocalDate.now(),
                HumidityLevel.BAJA,
                LocalDate.now().plusDays(14),
                "http://image.url",
                false,
                new ProfileId(1L));
        plantCommandService.handle(createCommand);
        Plant savedPlant = plantRepository.findAll().get(0);

        UpdatePlantCommand updateCommand = new UpdatePlantCommand(
                savedPlant.getId(),
                new PlantName("Updated Cactus"),
                "Cactaceae",
                LocalDate.now(),
                HumidityLevel.MEDIA,
                LocalDate.now().plusDays(10),
                "http://newimage.url",
                true,
                new ProfileId(1L));

        // Act
        Optional<Plant> updatedPlantResult = plantCommandService.handle(updateCommand);

        // Assert
        assertTrue(updatedPlantResult.isPresent());
        assertEquals("Updated Cactus", updatedPlantResult.get().getName().value());
        assertEquals(HumidityLevel.MEDIA, updatedPlantResult.get().getHumidity());
    }

   
}