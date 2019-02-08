# cae (Computerized Adaptive Engine)



maven setup for artifacts deploy to nexus:

add the following configuration in your local at ~/.m2/settings.xml  

```xml
<servers>
   <server>
     <id>rsinsights</id>
     <username>jenkins</username>
     <password>jenkins123</password>
   </server>
    <server>
      <id>rsinsights-snapshots</id>
      <username>jenkins</username>
      <password>jenkins123</password>
    </server>
   <server>
     <id>rsinsights-releases</id>
     <username>jenkins</username>
     <password>jenkins123</password>
   </server>
</servers>
 ```
 
 jenkins is the user created for the jenkins application (in rcs) [which can also be used in developers local] to deploy artifacts nexus.
 
 
 urls of the artifactory in pom file [when building app locally]--
 
 http://artifact-repo.rcs.rsiapps.com/repository/maven-public/
 
 http://artifact-repo.rcs.rsiapps.com/repository/maven-releases/
 
 http://artifact-repo.rcs.rsiapps.com/repository/maven-snapshots/
 
 urls of the artifactory in pom file [when building app in rcs cluster]--
 
 http://artifact-repo.service.rcsnp.rsiapps.internal/repository/maven-public/
 
 http://artifact-repo.service.rcsnp.rsiapps.internal/repository/maven-releases/
 
 http://artifact-repo.service.rcsnp.rsiapps.internal/repository/maven-snapshots/
 
