package com.opz.oasu.inventory.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import static com.opz.oasu.inventory.model.entity.Nomenclature.BARCODE_COLUMN_NAME;
import static com.opz.oasu.inventory.model.entity.Nomenclature.DESCRIPTION_COLUMN_NAME;
import static com.opz.oasu.inventory.model.entity.Nomenclature.ID_COLUMN_NAME;
import static com.opz.oasu.inventory.model.entity.Nomenclature.RESPONSIBLE_PERSON_ID_COLUMN_NAME;


@Entity(foreignKeys = @ForeignKey(
                entity = ResponsiblePerson.class,
                parentColumns = "id",
                childColumns = "responsible_person_id"),
        indices = {
                @Index(value = {ID_COLUMN_NAME, BARCODE_COLUMN_NAME}),
                @Index(value = DESCRIPTION_COLUMN_NAME),
                @Index(value = RESPONSIBLE_PERSON_ID_COLUMN_NAME)})
public class Nomenclature {

    static final String ID_COLUMN_NAME                              = "id";
    static final String BARCODE_COLUMN_NAME                         = "barcode";
    static final String DESCRIPTION_COLUMN_NAME                     = "description";
    static final String RESPONSIBLE_PERSON_ID_COLUMN_NAME           = "responsible_person_id";

    private static final String SAP_NUMBER_COLUMN_NAME              = "sap_number";
    private static final String SUB_NUMBER_COLUMN_NAME              = "subnumber";
    private static final String INVENTORY_CLASS_COLUMN_NAME         = "inventory_class";
    private static final String INTRODUCTION_DATE_COLUMN_NAME       = "introduction_date";
    private static final String SERIAL_NUMBER_COLUMN_NAME           = "serial_number";
    private static final String INVENTORY_NUMBER_COLUMN_NAME        = "inventory_number";
    private static final String IS_MARKED_COLUMN_NAME               = "is_marked";
    private static final String DEPARTMENT_NUMBER_COLUMN_NAME       = "department_number";
    private static final String DEPARTMENT_DESCRIPTION_COLUMN_NAME  = "department_description";
    private static final String PLAN_COUNT_COLUMN_NAME              = "plan_count";
    private static final String OBJECT_COUNT_COLUMN_NAME            = "object_count";
    private static final String IS_NEW_COLUMN_NAME                  = "is_new";
    private static final String IS_DELETED_COLUMN_NAME              = "is_deleted";
    private static final String TYPE_LABEL_COLUMN_NAME              = "type_label";
    private static final String INITIAL_COST_COLUMN_NAME            = "initial_cost";
    private static final String LEAST_COST_COLUMN_NAME              = "least_cost";
    private static final String LOCATION_COLUMN_NAME                = "location";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COLUMN_NAME)
    private long id;

    @ColumnInfo(name = BARCODE_COLUMN_NAME)
    private String barcode;

    @ColumnInfo(name = SAP_NUMBER_COLUMN_NAME)
    private String sapNumber;

    @ColumnInfo(name = SUB_NUMBER_COLUMN_NAME)
    private String subNumber;

    @ColumnInfo(name = INVENTORY_CLASS_COLUMN_NAME)
    private String inventoryClass;

    @ColumnInfo(name = DESCRIPTION_COLUMN_NAME)
    private String description;

    @ColumnInfo(name = INTRODUCTION_DATE_COLUMN_NAME)
    private Date introductionDate;

    @ColumnInfo(name = SERIAL_NUMBER_COLUMN_NAME)
    private String serialNumber;

    @ColumnInfo(name = INVENTORY_NUMBER_COLUMN_NAME)
    private String inventoryNumber;

    @ColumnInfo(name = IS_MARKED_COLUMN_NAME)
    private boolean isMarked;

    @ColumnInfo(name = DEPARTMENT_NUMBER_COLUMN_NAME)
    private int departmentNumber;

    @ColumnInfo(name = DEPARTMENT_DESCRIPTION_COLUMN_NAME)
    private String departmentDescription;

    @ColumnInfo(name = PLAN_COUNT_COLUMN_NAME)
    private long planCount;

    @ColumnInfo(name = OBJECT_COUNT_COLUMN_NAME)
    private long objectCount;

    @ColumnInfo(name = IS_NEW_COLUMN_NAME)
    private boolean isNew;

    @ColumnInfo(name = IS_DELETED_COLUMN_NAME)
    private boolean isDeleted;

    @ColumnInfo(name = TYPE_LABEL_COLUMN_NAME)
    private String typeLabel;

    @ColumnInfo(name = INITIAL_COST_COLUMN_NAME)
    private BigDecimal initialCost;

    @ColumnInfo(name = LEAST_COST_COLUMN_NAME)
    private BigDecimal leastCost;

    @ColumnInfo(name = RESPONSIBLE_PERSON_ID_COLUMN_NAME)
    private long responsiblePersonId;

    @ColumnInfo(name = LOCATION_COLUMN_NAME)
    private String location;

    public Nomenclature() { // JPA only
    }

    public long getId() {
        return id;
    }

    // Android's Room framework can not access primary key without setter (Hibernate style)
    public void setId(long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSapNumber() {
        return sapNumber;
    }

    public void setSapNumber(String sapNumber) {
        this.sapNumber = sapNumber;
    }

    public String getSubNumber() {
        return subNumber;
    }

    public void setSubNumber(String subNumber) {
        this.subNumber = subNumber;
    }

    public String getInventoryClass() {
        return inventoryClass;
    }

    public void setInventoryClass(String inventoryClass) {
        this.inventoryClass = inventoryClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getIntroductionDate() {
        return introductionDate;
    }

    public void setIntroductionDate(Date introductionDate) {
        this.introductionDate = introductionDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public long getPlanCount() {
        return planCount;
    }

    public void setPlanCount(long planCount) {
        this.planCount = planCount;
    }

    public long getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(long objectCount) {
        this.objectCount = objectCount;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    public BigDecimal getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(BigDecimal initialCost) {
        this.initialCost = initialCost;
    }

    public BigDecimal getLeastCost() {
        return leastCost;
    }

    public void setLeastCost(BigDecimal leastCost) {
        this.leastCost = leastCost;
    }

    public long getResponsiblePersonId() {
        return responsiblePersonId;
    }

    public void setResponsiblePersonId(long responsiblePersonId) {
        this.responsiblePersonId = responsiblePersonId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nomenclature that = (Nomenclature) o;
        return getInventoryClass() == that.getInventoryClass() &&
                getInventoryNumber() == that.getInventoryNumber() &&
                isMarked() == that.isMarked() &&
                getDepartmentNumber() == that.getDepartmentNumber() &&
                getPlanCount() == that.getPlanCount() &&
                getObjectCount() == that.getObjectCount() &&
                isNew() == that.isNew() &&
                isDeleted() == that.isDeleted() &&
                getResponsiblePersonId() == that.getResponsiblePersonId() &&
                Objects.equals(getBarcode(), that.getBarcode()) &&
                Objects.equals(getSapNumber(), that.getSapNumber()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getIntroductionDate(), that.getIntroductionDate()) &&
                Objects.equals(getSerialNumber(), that.getSerialNumber()) &&
                Objects.equals(getDepartmentDescription(), that.getDepartmentDescription()) &&
                Objects.equals(getTypeLabel(), that.getTypeLabel()) &&
                Objects.equals(getInitialCost(), that.getInitialCost()) &&
                Objects.equals(getLeastCost(), that.getLeastCost()) &&
                Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBarcode(), getSapNumber(), getInventoryClass(), getDescription(), getIntroductionDate(), getSerialNumber(), getInventoryNumber(), isMarked(), getDepartmentNumber(), getDepartmentDescription(), getPlanCount(), getObjectCount(), isNew(), isDeleted(), getTypeLabel(), getInitialCost(), getLeastCost(), getResponsiblePersonId(), getLocation());
    }
}
