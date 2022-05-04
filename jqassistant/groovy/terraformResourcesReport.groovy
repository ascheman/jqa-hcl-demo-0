#!/usr/bin/env groovy

File reportFile = new File(reportDirectory, "terraform-resources.adoc")
logger.info ("Creating report file '{}'", reportFile)

reportFile.write """= ${concept.description}

Provided by `${concept.id}`

|===
| ${result?.columnNames?.join(' | ')}

"""

result?.rows?.each {row ->
    row.each { key, value ->
        reportFile << "| ${value} "
    }
    reportFile << "\n"
}

reportFile << "|==="