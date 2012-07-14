package com.artisan_programming

import cucumber.table.DataTable

class SingleRowTable {
    DataTable table

    SingleRowTable(DataTable table) {
        this.table = table
    }

    def propertyMissing(String name) {
        int columnIndex = table.topCells().indexOf(name)

        if (columnIndex < 0) {
            throw new MissingPropertyException(name, this.getClass())
        }

        return table.raw()[1][columnIndex]
    }
}
