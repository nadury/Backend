
rootProject.name = "nadul"
include("api")
include("infra")
include("infra:mysql")
findProject(":infra:mysql")?.name = "mysql"
include("infra:httpClient")
findProject(":infra:httpClient")?.name = "httpClient"
