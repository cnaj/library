node {
  stage 'Checkout'
  checkout scm

  stage "build"
  def mvnHome = tool 'M3'
  sh "${mvnHome}/bin/mvn -B verify"
  junit '**/target/surefire-reports/TEST-*.xml'
}
