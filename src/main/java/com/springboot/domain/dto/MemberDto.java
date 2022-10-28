package com.springboot.domain.dto;

public class MemberDto {
    private String name;
    private String email;
    private String organization;

    public MemberDto(String name, String email, String organization){
        this.name=name;
        this.email=email;
        this.organization=organization;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }
    @Override
    public String toString(){
        return String.format("MemberDto{name='%s', email='%s', organization='%s'}", name, email, organization);
    }
}