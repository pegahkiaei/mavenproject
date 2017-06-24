/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller.model;

public class TermsData {

    private int term;//ترم
    private String termState;//وضعیت ترم
    private int termTakenCredits;//واحد اخذ شده ترم
    private int consecutiveTakenCredits;//واحد اخذ شده متوالی
    private int termPassedCredits;//واحد گذرانده شده ترم
    private int totalPassedCredits;//واحد گذرانده شده کل
    private int consecutivePassedCredits;//واحد گذرانده شده متوالی
    private int unknownCredits;//واحدهای اعلام نشده
    private int notFinishedCredits=0;//واحدهای ناتمام
    private int failedCredits;//واخدای ردی
    private float GPA;
    private float totalGPA;
    private String provided;//مشروط
    private int tuition;//شهریه

    public TermsData() {
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getTermState() {
        return termState;
    }

    public void setTermState(String termState) {
        this.termState = termState;
    }

    public int getTermTakenCredits() {
        return termTakenCredits;
    }

    public void setTermTakenCredits(int termTakenCredits) {
        this.termTakenCredits = termTakenCredits;
    }

    public int getConsecutiveTakenCredits() {
        return consecutiveTakenCredits;
    }

    public void setConsecutiveTakenCredits(int consecutiveTakenCredits) {
        this.consecutiveTakenCredits = consecutiveTakenCredits;
    }

    public int getTermPassedCredits() {
        return termPassedCredits;
    }

    public void setTermPassedCredits(int termPassedCredits) {
        this.termPassedCredits = termPassedCredits;
    }

    public int getTotalPassedCredits() {
        return totalPassedCredits;
    }

    public void setTotalPassedCredits(int totalPassedCredits) {
        this.totalPassedCredits = totalPassedCredits;
    }

    public int getConsecutivePassedCredits() {
        return consecutivePassedCredits;
    }

    public void setConsecutivePassedCredits(int consecutivePassedCredits) {
        this.consecutivePassedCredits = consecutivePassedCredits;
    }

    public int getUnknownCredits() {
        return unknownCredits;
    }

    public void setUnknownCredits(int unknownCredits) {
        this.unknownCredits = unknownCredits;
    }

    public int getNotFinishedCredits() {
        return notFinishedCredits;
    }

    public void setNotFinishedCredits(int notFinishedCredits) {
        this.notFinishedCredits = notFinishedCredits;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public float getTotalGPA() {
        return totalGPA;
    }

    public void setTotalGPA(float totalGPA) {
        this.totalGPA = totalGPA;
    }

    public String getProvided() {
        return provided;
    }

    public String isProvided() {
        return provided;
    }

    public void setProvided(String provided) {
        this.provided = provided;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public int getFailedCredits() {
        return failedCredits;
    }

    public void setFailedCredits(int failedCredits) {
        this.failedCredits = failedCredits;
    }
}
