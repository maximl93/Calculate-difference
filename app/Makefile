make run-dist:
	./build/install/app/bin/app

make build:
	./gradlew clean build
	./gradlew clean install
	./gradlew test
	./gradlew checkstyleMain

make report:
	./gradlew jacocoTestReport

.PHONY: build
