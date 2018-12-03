#!/bin/bash
set -e

EXIT_STATUS=0

rm -rf *.zip

./gradlew clean test assemble || EXIT_STATUS=$?

filename=$(find build/libs -name "*.jar" | head -1)
filename=$(basename "$filename")

if [ $EXIT_STATUS -ne 0 ]; then
  exit $EXIT_STATUS
fi

if [ "${TRAVIS_JDK_VERSION}" == "openjdk11" ] ; then
  exit $EXIT_STATUS
fi

echo "Publishing archives for branch $TRAVIS_BRANCH JDK: $TRAVIS_JDK_VERSION"
if [[ -n $TRAVIS_TAG ]] || [[ $TRAVIS_BRANCH == 'master' && $TRAVIS_PULL_REQUEST == 'false' ]]; then

  echo "Publishing archives"

  if [[ -n $TRAVIS_TAG ]]; then
      ./gradlew bintrayUpload || EXIT_STATUS=$?
  else
      ./gradlew publish || EXIT_STATUS=$?
  fi

fi

exit $EXIT_STATUS
