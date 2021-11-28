//CODE_CHANGES = getGitChanges() //- variable that checks if there are any code changes.
pipline{ //- must be top-level.
//Declaring that wer'e writing a Pipline.
    agent any //- where to execute
    //this build will be running on any available Jenkins agent.
    //an 'agent' can be a note, an executer on that note etc...
    //it's more relevant when we have a Jenkins cluster with
    //master and slave where we have nodes in Windows or Linux etc.
    stages{//- where the "work" is actually heppens
    //contains all the stages and steps in the process
        stage("build"){
            steps{
                echo "building the application..."
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
                }
            }
            steps{
                echo "testing the application..."
            }
        }
        stage("deploy"){
            steps{
                echo "deploying the application..."
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