Continuous Integration with AWS CodeBuild

- Purpose: Run Maven build and unit tests automatically on every build.

Quick Start

- Build locally: `mvn clean test -s settings.xml`
- Full build (tests + WAR): `mvn clean install -s settings.xml`

Project Layout

- App code: `src/main/java/com/nextwork/app/Hello.java:1`
- Unit test: `src/test/java/com/nextwork/app/HelloTest.java:1`
- Web assets: `src/main/webapp/index.jsp:1`
- Build spec: `buildspec.yml:1`
- Maven config: `pom.xml:1`, `settings.xml:1`

How CodeBuild Runs Tests

- Runtime: Corretto 8 (see `buildspec.yml:1`).
- Pre-build: Logs into CodeArtifact and exports `CODEARTIFACT_AUTH_TOKEN`.
- Build: Runs `mvn clean install -s settings.xml`, which compiles and runs tests via Surefire.
- Artifacts: Uploads `target/*.war`.

Trigger a Build

- Console: Start a build on your CodeBuild project connected to this repo/branch.
- CLI: `aws codebuild start-build --project-name <your-project-name>`
- Verify: In the build logs, look for Maven Surefire summary and passing tests for `HelloTest`.

Advanced Tips

- Test reports: Enable a CodeBuild Report Group (JUnit XML) and point it at `target/surefire-reports/TEST-*.xml` to get rich test visualizations.
- Dependency cache: Configure project-level local caching for `/root/.m2/repository` to speed builds.
- Fail fast: Keep tests fast and isolated; add more unit tests under `src/test/java` and they’ll run automatically.

