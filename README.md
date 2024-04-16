# jobrunr-carbon-aware-scheduling-test

A demo Spring boot app that tests JobRunr's carbon-aware-scheduling feature

## How to install JobRunr v7.0.0-carbon-aware

1. Clone JobRunr OSS repository
2. Checkout `feature/carbon-aware-jobs` branch
3. In class `CarbonAwareConfiguration`, change the `DEFAULT_CARBON_AWARE_API_URL` constant to `http://jobrunr-carbon-api-dev.swedencentral.cloudapp.azure.com:10000` 
4. `export DRONE_TAG=v7.0.0-carbon-aware`
5. `./gradlew publishToMavenLocal`


## How to run the demo app

`./mvn spring-boot:run`

## How to test the carbon-aware-scheduling feature

1. Navigate to `http://localhost:8080/swagger-ui/index.html`
2. Create a new carbon-aware job
3. Go to database and check the `jobrunr-job` table. Or check the jobrunr dashboard at `http://localhost:8000`


Also, experiment with the `area` in `application.properties`
