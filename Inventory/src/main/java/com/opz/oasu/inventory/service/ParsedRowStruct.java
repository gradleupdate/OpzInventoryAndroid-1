package com.opz.oasu.inventory.service;

import java.util.Objects;

public final class ParsedRowStruct {
    private final String barcode;
    private final String sapNumber;
    private final String subNumber;
    private final String inventoryClass;
    private final String description;
    private final String introductionDate;
    private final String serialNumber;
    private final String inventoryNumber;
    private final double isMarked;
    private final String departmentNumber;
    private final String departmentDescription;
    private final double planCount;
    private final double objectsCount;
    private final double isNew;
    private final double isDeleted;
    private final String typeLabel;
    private final double initialCost;
    private final double leastCost;
    private final String responsiblePersonName;
    private final double responsiblePersonTableNumber;
    private final String location;

    ParsedRowStruct(
            String barcode,
            String sapNumber,
            String subNumber,
            String inventoryClass,
            String description,
            String introductionDate,
            String serialNumber,
            String inventoryNumber,
            double isMarked,
            String departmentNumber,
            String departmentDescription,
            double planCount,
            double objectsCount,
            double isNew,
            double isDeleted,
            String typeLabel,
            double initialCost,
            double leastCost,
            String responsiblePersonName,
            double responsiblePersonTableNumber,
            String location) {
        this.barcode = barcode;
        this.sapNumber = sapNumber;
        this.subNumber = subNumber;
        this.inventoryClass = inventoryClass;
        this.description = description;
        this.introductionDate = introductionDate;
        this.serialNumber = serialNumber;
        this.inventoryNumber = inventoryNumber;
        this.isMarked = isMarked;
        this.departmentNumber = departmentNumber;
        this.departmentDescription = departmentDescription;
        this.planCount = planCount;
        this.objectsCount = objectsCount;
        this.isNew = isNew;
        this.isDeleted = isDeleted;
        this.typeLabel = typeLabel;
        this.initialCost = initialCost;
        this.leastCost = leastCost;
        this.responsiblePersonName = responsiblePersonName;
        this.responsiblePersonTableNumber = responsiblePersonTableNumber;
        this.location = location;
    }

    @Override
    public String toString() {
        return "ParsedRowStruct{" +
                "barcode='" + barcode + '\'' +
                ", sapNumber='" + sapNumber + '\'' +
                ", subNumber='" + subNumber + '\'' +
                ", inventoryClass='" + inventoryClass + '\'' +
                ", description='" + description + '\'' +
                ", introductionDate='" + introductionDate + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", inventoryNumber='" + inventoryNumber + '\'' +
                ", isMarked=" + isMarked +
                ", departmentNumber='" + departmentNumber + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
                ", planCount=" + planCount +
                ", objectsCount=" + objectsCount +
                ", isNew=" + isNew +
                ", isDeleted=" + isDeleted +
                ", typeLabel='" + typeLabel + '\'' +
                ", initialCost=" + initialCost +
                ", leastCost=" + leastCost +
                ", responsiblePersonName='" + responsiblePersonName + '\'' +
                ", responsiblePersonTableNumber=" + responsiblePersonTableNumber +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedRowStruct that = (ParsedRowStruct) o;
        return Double.compare(that.isMarked, isMarked) == 0 &&
                Double.compare(that.planCount, planCount) == 0 &&
                Double.compare(that.objectsCount, objectsCount) == 0 &&
                Double.compare(that.isNew, isNew) == 0 &&
                Double.compare(that.isDeleted, isDeleted) == 0 &&
                Double.compare(that.initialCost, initialCost) == 0 &&
                Double.compare(that.leastCost, leastCost) == 0 &&
                Double.compare(that.responsiblePersonTableNumber, responsiblePersonTableNumber) == 0 &&
                Objects.equals(barcode, that.barcode) &&
                Objects.equals(sapNumber, that.sapNumber) &&
                Objects.equals(subNumber, that.subNumber) &&
                Objects.equals(inventoryClass, that.inventoryClass) &&
                Objects.equals(description, that.description) &&
                Objects.equals(introductionDate, that.introductionDate) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(inventoryNumber, that.inventoryNumber) &&
                Objects.equals(departmentNumber, that.departmentNumber) &&
                Objects.equals(departmentDescription, that.departmentDescription) &&
                Objects.equals(typeLabel, that.typeLabel) &&
                Objects.equals(responsiblePersonName, that.responsiblePersonName) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, sapNumber, subNumber, inventoryClass, description, introductionDate, serialNumber, inventoryNumber, isMarked, departmentNumber, departmentDescription, planCount, objectsCount, isNew, isDeleted, typeLabel, initialCost, leastCost, responsiblePersonName, responsiblePersonTableNumber, location);
    }
}
