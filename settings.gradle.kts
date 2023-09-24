
rootProject.name = "nadul"
include("api")
include("infra")
include("infra:mysql")
findProject(":infra:mysql")?.name = "mysql"
