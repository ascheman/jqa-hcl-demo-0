#!/usr/bin/env groovy

File reportFile = new File(reportDirectory, "report.adoc")
logger.info ("Creating report file '{}'", reportFile)

reportFile.write """= ${concept.id}

${concept.description}

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