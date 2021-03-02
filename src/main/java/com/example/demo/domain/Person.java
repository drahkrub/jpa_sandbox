package com.example.demo.domain;

import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;

/**
 * @author Burkhard Graves
 */
@Entity
public class Person extends IdOnly {
    
    @OneToMany
    @JoinTable(name = "person_to_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @MapKeyJoinColumn(name = "project_id")
    private Map<Project, Role> roles;

    public Map<Project, Role> getRoles() {
        return roles;
    }

    public void setRoles(Map<Project, Role> roles) {
        this.roles = roles;
    }
}
