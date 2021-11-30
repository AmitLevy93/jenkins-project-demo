def buildApp(){
    echo 'building the application...'
    echo "building version ${NEW_VERSION}"
    sh "mvn install"
}

def testApp(){
    echo 'testing the application...'
}

def deployApp(){
    echo 'deploying the application...'
    //echo "deploying with ${SERVER_CREDENTIALS}" // but instead of it we can use:
    /*withCredentials([
        usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
    ]){
        sh "some script ${USER} ${PWD}"
    }*/
    echo "deploying version ${params.VERSION}"
}
return this //it's importent to mention if we need to
//run this function in a Jenkinsfile.