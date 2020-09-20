String basePath = 'Smile'
String repo = 'https://github.com/trexsolutions/smile-cdk'

folder(basePath) {
	description('Smile Folder')
}

pipelineJob("$basePath/smile-builder") {
	description('Builds smile-builder image and pushes to ecr')
	definition {
    	cpsScm {
        	scm {
            	git {
                	remote {
						credentials('jenkins-github')
                		url(repo)
                    }
                    branches('*/master')
                }
            }
            scriptPath('pipelines/smile-builder/Jenkinsfile')
        }
	}
}

