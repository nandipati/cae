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
