# jobrunr-carbon-aware-scheduling-test

A demo Spring boot app that tests JobRunr's carbon-aware-scheduling feature

## Pre-requisites

1. Setup `carbon-aware-api` (remote or localhost)

## How to install JobRunr v7.0.0-carbon-aware

1. Clone JobRunr OSS repository (`git clone git@github.com:jobrunr/jobrunr.git`)
2. Checkout `feature/carbon-aware-jobs` branch
3. In class `CarbonAwareConfiguration`, change the `DEFAULT_CARBON_AWARE_API_URL` constant to `carbon-aware-api`'s URI (ex. `http://localhost:10000`). Or use my server `http://34.125.156.29:10000` if it is still alive.
4. `export DRONE_TAG=v7.2.0-carbon-aware`
5. `./gradlew publishToMavenLocal`


## How to run the demo app

`mvn spring-boot:run`

## How to test the carbon-aware-scheduling feature

1. Navigate to `http://localhost:10500/swagger-ui/index.html`
2. Create a new carbon-aware job
3. Go to database and check the `jobrunr-job` table. Or check the jobrunr dashboard at `http://localhost:8500`


Also, experiment with the `area` in `application.properties`
