-------------------------------------------Docker--------------------------------------------------

Jenkin login :
```
 - admin
 - Root@123
 - admin@gmail.com
```

Jenkin Set up:
```
    wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo

    rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key

    yum install jenkins

    service jenkins start

    cat /var/lib/jenkins/secrets/initialAdminPassword

    service jenkins start

    yum remove jenkins

    rm -rf /var/lib/jenkins

    Java Path:

    /lib/jvm/java-1.8.0-openjdk-1.8.0.242.b08-0.amzn2.0.1.x86_64

    Maven Path:

    /usr/share/maven

    Git Path:

    /usr/bin/git

    Assign Root User and Permissions:

    vi /etc/sysconfig/jenkins

    chown -R root:root /var/lib/jenkins
    chown -R root:root /var/cache/jenkins
    chown -R root:root /var/log/jenkins

    service jenkins restart
```

Implementing  Jenkins project :

```
> Click on the create a job button:
    Step 2 : Enter job name
    Step 3 : Select freestyle project
    Step 4 : Click on the save

> Job config page for Maven
    Step 1 : Click on build Tab
    Step 2 : Click on add build step
    Step 3 : Select invoke top level Maven option
    Step 4 : Select the required maven version
    Step 5 : Select the goal has "clean install"
    Step 6 : Give the pom xml file location
    Step 7 : Click save button

> Jenkins Working with git repo
    Step 1 : Click on Config Option
    Step 2 : Click on Source Code Management tab
    Step 3 : Select Git option
    Step 4 : Give the Git Repo URL
    Step 5 : Click save button

> Build Manual Trigger
    Step 1 : Click on Build Now option
    Step 2 : Under Build History select the Job you want to see the run status

> Build Auto Trigger with git repo changes
    Step 1 : Click on Config Option
    Step 2 : Click on Build Trigger tab
    Step 3 : Select GitHub hook trigger option
    Step 4 : Click save button
 ```
 
Config Security:
```
    Step 1: Manager Jenkins 
    Step 2: Manage Users
    Step 3: Under Authorization select Matrix Based
    Step 4: Add the user we need to config
    Step 5: select the user/group option needed
```

Deployment in jenkins:
```
    yum install tomcat
    yum install tomcat-webapps tomcat-admin-webapps
    service tomcat start
    Config User : 
     vi /usr/share/tomcat/conf/tomcat-users.xml
     <user username="deployer" password="deployer" roles="manager-script"/>
    Add the plugin "deployment container"from plugin manager
    Use the existing job with the git repo linked
    Post build action
     **/java-web-project.war
     app name
     container version and type
     save
```
Web Hooks in jenkins:
```
   Step 1: GitHub project , select web hook option
   Step 2: Add web Hook, give the jenkins url
   Step 3: Add content type
   Step 4: select the push event, add web hooks button
   Step 5: goto jenkins > build trigger > select the github hooks trigger 
``` 

    


