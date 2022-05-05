#!/usr/bin/env groovy

File reportFile = new File(reportDirectory, "terraform-usage.puml")
logger.info ("Creating report file '{}'", reportFile)

def components = new HashSet<String>()
result?.rows?.each {row ->
    components.add(row.src)
    components.add(row.tgt)
}
logger.info ("Found #{} components", components.size())

reportFile.write """@startuml

"""

components.each { comp ->
    reportFile << "component ${comp}\n"
}

result?.rows?.each {row ->
    reportFile << "${row.src} --> ${row.tgt} : uses\n"
}

reportFile << """
@enduml"""