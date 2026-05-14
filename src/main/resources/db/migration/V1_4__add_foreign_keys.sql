ALTER TABLE tasks
    ADD CONSTRAINT FK_tasks_profile_id
        FOREIGN KEY (profile_id)
            REFERENCES profiles (id);


ALTER TABLE tasks
    ADD CONSTRAINT FK_tasks_plant_id
        FOREIGN KEY (plant_id)
            REFERENCES plants (id);



ALTER TABLE plant_histories
    ADD CONSTRAINT FK_planthistories_plant_id
        FOREIGN KEY (plant_id)
            REFERENCES plants (id);

ALTER TABLE profiles
    ADD CONSTRAINT FK_profiles_user_id
        FOREIGN KEY (user_id)
            REFERENCES users (id);


