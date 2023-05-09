pipeline {
    agent any
    tools {
        maven '3.9.1'
    }


    stages {

        stage('Create secrets.yaml') {
            environment{
                vpass = credentials('JENKINS-V-USERNAME')
                ivpass = credentials('JENKINS-IN-USERNAME')
                }
                steps {

                // Create secrets.yaml file
                sh 'touch src/main/java/resources/secrets.yaml'
                // Add values to secrets.yaml
                sh 'echo "validEmail: pythontesting3134@gmail.com" > src/main/java/resources/secrets.yaml'
                sh 'echo "validPassword: $vpass" >> src/main/java/resources/secrets.yaml'
                sh 'echo "inValidEmail: pythontesting@gmail.com" >> src/main/java/resources/secrets.yaml'
                sh 'echo "inValidPassword: $ivpass" >> src/main/java/resources/secrets.yaml'
            }
        }

        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"

                '''
            }
        }

        stage('Download ChromeDriver') {
            steps {
                sh "curl -o chromedriver_mac64.zip https://chromedriver.storage.googleapis.com/112.0.5615.49/chromedriver_mac64.zip"
                sh "unzip -o ./chromedriver_mac64.zip -d ./"
                sh "chmod +x ./chromedriver"
            }
        }

        stage ('Checkout'){
            steps{
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/PriyankaV12/amazon-end-to-end.git',

                    ]]
                ])
            }
        }
        stage ('Run Tests') {
            steps {
                sh 'ls -al'
                sh 'mvn test'

            }

        }

        stage('Publish HTML Report') {
    steps {
            publishHTML([allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: false,
            reportDir: 'target',
            reportFiles: 'index.html',
            reportName: 'HTML Report01',
        ])
    }
}

    }
}