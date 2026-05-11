pipeline {
  agent any
  tools {
    maven 'MAVEN_3_9_15'
    jdk 'JDK_21'
  }

  stages {
    stage ('Compile Project') {
      steps {
        withMaven(maven : 'MAVEN_3_9_15') {
            sh 'mvn clean compile'
        }
      }
    }

    /* stage('Validate Checkstyle') {
      steps {
        withMaven(maven: 'MAVEN_3_9_15') {
          sh 'mvn checkstyle:check'
        }
      }
    }
    */

    stage('Validate Unit Tests') {
      steps {
        withMaven(maven: 'MAVEN_3_9_15') {
          sh 'mvn test'
        }
      }
    }

    stage('Validate Test Coverage') {
      steps {
        withMaven(maven: 'MAVEN_3_9_15') {
          sh 'mvn clean verify jacoco:report'
          sh 'mvn jacoco:check'
        }
      }
    }

    /* stage ('SonarQube Analysis') {
        steps {
            withSonarQubeEnv('sonarLocal') {
                sh 'mvn verify sonar:sonar -Dsonar.projectKey=plantsync_backend'
                // Nota: se usa 'sh' para Linux o 'bat' si Jenkins corre sobre Windows
            }
        }
     }
     */

    stage ('Package Project') {
        steps {
            withMaven(maven : 'MAVEN_3_9_15') {
                // Se agrega -DskipTests porque los tests ya corrieron y pasaron en los stages anteriores
                sh 'mvn package -DskipTests'
            }
        }
    }
  }
}