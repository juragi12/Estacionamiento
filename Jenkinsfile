pipeline{
 	//Donde se va a ejecutar el Pipeline
	 agent {
	 	label 'Slave_Induccion'
	 }
	 
	 //Opciones específicas de Pipeline dentro del Pipeline
	 options {
		//Mantener artefactos y salida de consola para el # específico de ejecuciones recientes del Pipeline.
		buildDiscarder(logRotator(numToKeepStr: '5'))
		
		//No permitir ejecuciones concurrentes de Pipeline
		disableConcurrentBuilds()
	 }
	 
	//Una sección que define las herramientas para “autoinstalar” y poner en la PATH
	 tools {
	 	jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
		gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master
	 }
	 
	 
	 //Aquí comienzan los “items” del Pipeline
	 stages{
	 	stage('Checkout') {
	 		steps{
		 			echo "------------>Checkout<------------"
		 			checkout([$class: 'GitSCM', 
		 			branches: [[name: '*/master']],
					doGenerateSubmoduleConfigurations: false, 
					extensions: [], 
					gitTool: 'Git_Centos', 
					submoduleCfg: [], 
					userRemoteConfigs: 
						[[
							credentialsId: 'GitHub_juragi12', 
							url: 'https://github.com/juragi12/Estacionamiento.git'
						]]])
						
					sh 'gradle clean'
	 			}
	 	}
	
		stage('Compile') {
			steps{
					echo "------------>Compile<------------"
					sh 'gradle --b ./build.gradle compileJava'
			}
		}
		
		stage('Unit Tests') {
			steps{
		 			echo "------------>Unit Tests<------------"
		 			sh 'gradle --stacktrace test'
					junit '**/build/test-results/test/*.xml' //aggregate test results - JUnit
					step( [ $class: 'JacocoPublisher' ] )
	 			}
	 	}
	 
	 	stage('Integration Tests') {
	 		steps {
	 				echo "------------>Integration Tests<------------"
	 			}
		}
	 
	 	stage('Static Code Analysis') {
	 		steps{
		 			echo '------------>Análisis de código estático<------------'
		 			withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
					}
	 			}
	 	}
	 	
	 	stage('Build') {
	 		steps {
		 			echo "------------>Build<------------"
		 			sh 'gradle --b ./build.gradle build -x test'
	 			}
		}
	 }
	 
}