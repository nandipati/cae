job "caeAPI" {

  constraint {
    attribute = "${attr.kernel.name}"
    operator  = "="
    value     = "linux"
  }

  constraint {
    attribute = "${meta.group}"
    operator = "set_contains"
    value = "adaptive-services"
  }

  constraint {
    attribute = "${meta.env}"
    operator = "="
    value = "rcscorenp"
  }

  constraint {
    attribute = "${node.class}"
    operator = "set_contains"
    value     = "ENVIRONMENT"       //replace it depending on the env it is running
  }

  datacenters = ["dc1"]

  group "adaptive" {
    count = 1

    restart {
      attempts = 3
      interval = "5m"
      delay = "25s"

      mode = "delay"
    }

    task "TASK-STAGE" {
      driver = "docker"
      config {
        image = "artifact-repo.service.rcsnp.rsiapps.internal:6070/rcs/adaptive/cae-api:tag" //use consul template get the value of easycbm_git_sha and other from consul assuming jenkins put it in consul after the docker built and pushed
        volumes = [
          # Used named volume created outside nomad.
          "/home/ec2-user/mnt/efs/rcs-app01/adaptive-ENVIRONMENT:/tmp:rw"
        ]
        privileged = true
        port_map {
          http = 8080

        }
        args = ["/usr/lib/jvm/java-1.8-openjdk/bin/java","-jar","/app.jar","--server.port=8080","--management.port=8888"],
      }
      logs {
        max_files     = 10
        max_file_size = 25
      }
      service {
        name = "TASK-STAGE"       //replace name based on the env it is running
        port = "http"
      }
      resources {
        cpu = 300
        memory = 1000
        disk = 500
        network {
          mbits = 100
          port "http" {
            static = "80"
          }
        }
      }
    }
  }
}