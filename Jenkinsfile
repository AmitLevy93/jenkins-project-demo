//def gv
//Variables - we can find the whole list in the URL:
//http://localhost:8080/env-vars.html/
//Such as: BRANCH_NAME ...

//CODE_CHANGES = getGitChanges() //- variable that checks if there are any code changes.

pipline{ //- must be top-level.
//Declaring that wer'e writing a Pipline.
    
    agent any //- where to execute
    //this build will be running on any available Jenkins agent.
    //an 'agent' can be a note, an executer on that note etc...
    //it's more relevant when we have a Jenkins cluster with
    //master and slave where we have nodes in Windows or Linux etc.

    environment{
        //the Environment Variables we declering here are available for all the stages.
        NEW_VERSION = '1.3.0'
        //SERVER_CREDENTIALS = credentials('')// in the '' we mention the credentials we configured in Jenkins.
        //SERVER_CREDENTIALS = credentials('server-credentials')
    }

    tools{
        //Provides us build tools for our projects: Maven, Gradle, JDK.
        maven 'Maven'
        //gradle
        //jdk
    }

    parameters{
        string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        boolianParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages{//- where the "work" is actually heppens
    //contains all the stages and steps in the process
        stage("init"){
            steps{
                script{
                    //'script' tag is meant for running a groovy script. 
                    gv = load "script.groovy"
                }
            }
        }
        stage("build"){
            steps{
                script{
                    gv.buildApp()
                }
            }
        }
        stage("test"){
            when{
            //when should this stage will execute.
                expression{
                //here we find our boolian expressions, the current active branch-name in the build.
                    BRANCH_NAME == 'master' //checks if the current branch is 'master'.
                    //if it's not, its gonna skip.
                    //env.BRANCH_NAME - environment variable
                    
                    //BRANCH_NAME == 'master' || BRANCH_NAME == 'main' //we can also check if its one of these branches.

                    //BRANCH_NAME == 'master' || CODE_CHANGES == true
                    //the variable 'CODE_CHANGES' can be defined in the first lines of the code.

                    params.executeTests // == true
                }
            }
            steps{
                script{
                    gv.testApp()
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
    }
    /*post{
    //post - Execute some logic AFTER all stages executed.
    //configures the Build Status or the Build Status Changes.
        always{
        //always - the script or logic insid there will
        //be executed always, no matter if it's works or failes.
        //For Example, if there is a need of sending a mail to a team.
        }
        success{
        //success - relevant only if the build was succeeded.
        }
        failure{
        //failure - relevant only if the build was failed.
        }
    }*/
}

/*node{
    // equivalent to the first 2 lines: 'pipline' and 'agent any'
    //inside of it we will write a Groovy script
}*/