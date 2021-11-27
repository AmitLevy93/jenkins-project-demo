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
}

//node{
    // equivalent to the first 2 lines: 'pipline' and 'agent any'
    //inside of it we will write a Groovy script
//}