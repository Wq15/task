package com.pojo;

public class Profession {
    private Integer id;

    private String image;

    private Long name;

    private String professionDirection;

    private String professionDescription;

    private String threshold;

    private String difficulty;

    private String growthCycle;

    private String requirements;

    private String periodOne;

    private String periodTwo;

    private String periodThree;

    private String salaryOne;

    private String salaryTwo;

    private String salaryThree;

    private String number;

    private String tips;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public String getProfessionDirection() {
        return professionDirection;
    }

    public void setProfessionDirection(String professionDirection) {
        this.professionDirection = professionDirection == null ? null : professionDirection.trim();
    }

    public String getProfessionDescription() {
        return professionDescription;
    }

    public void setProfessionDescription(String professionDescription) {
        this.professionDescription = professionDescription == null ? null : professionDescription.trim();
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold == null ? null : threshold.trim();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle == null ? null : growthCycle.trim();
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements == null ? null : requirements.trim();
    }

    public String getPeriodOne() {
        return periodOne;
    }

    public void setPeriodOne(String periodOne) {
        this.periodOne = periodOne == null ? null : periodOne.trim();
    }

    public String getPeriodTwo() {
        return periodTwo;
    }

    public void setPeriodTwo(String periodTwo) {
        this.periodTwo = periodTwo == null ? null : periodTwo.trim();
    }

    public String getPeriodThree() {
        return periodThree;
    }

    public void setPeriodThree(String periodThree) {
        this.periodThree = periodThree == null ? null : periodThree.trim();
    }

    public String getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(String salaryOne) {
        this.salaryOne = salaryOne == null ? null : salaryOne.trim();
    }

    public String getSalaryTwo() {
        return salaryTwo;
    }

    public void setSalaryTwo(String salaryTwo) {
        this.salaryTwo = salaryTwo == null ? null : salaryTwo.trim();
    }

    public String getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(String salaryThree) {
        this.salaryThree = salaryThree == null ? null : salaryThree.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }
}