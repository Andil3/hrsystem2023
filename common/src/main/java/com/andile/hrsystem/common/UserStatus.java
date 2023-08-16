/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.andile.hrsystem.common;

/**
 *
 * @author S2026080
 */
public enum UserStatus {
    ACTIVE("Active"), INACTIVE("Inactive");
    
    private final String displayName;

    UserStatus(final String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
