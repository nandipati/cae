job "caeAPI" {

  constraint {
    attribute = "${attr.kernel.name}"
    operator  = "="
    value     = "linux"
  }

  constraint {
    attribute = "${meta.group}"
    operator = "set_contains"
    value = "rcs-easycbm"         //for now run in easy-cbm group..but need to create a new group for adaptive
  }

  constraint {
    attribute = "${meta.env}"
    operator = "="
    value = "cndcorenp"
  }

  constraint {
    attribute = "${node.class}"
    operator = "set_contains"
    value     = "TEST"
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

    task "caeAPI" {
      driver = "docker"
      config {
        image = "artifact-repo.service.cndnp.hmheng.internal:6070/rcs/adaptive/caeAPI:tag" //use consul template get the value of easycbm_git_sha and other from consul assuming jenkins put it in consul after the docker built and pushed
        volumes = [
          # Used named volume created outside nomad.
          "/home/ec2-user/mnt/efs/rcs-app01/adaptive:/tmp:rw"
        ]
        privileged = true
        port_map {
          http = 80

        }

      }
      logs {
        max_files     = 10
        max_file_size = 25
      }
      service {
        name = "caeAPI"
        port = "http"
      }
      resources {
        cpu = 500
        memory = 500
        disk = 500
        network {
          mbits = 100
          port "http" {
            static = "8081"
          }
        }
      }
    }
  }
}