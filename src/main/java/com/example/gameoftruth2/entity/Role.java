package com.example.gameoftruth2.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Data
@Entity
@Table(name = "authorities")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private RoleType authority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    public GrantedAuthority toAuthority() {
        return new SimpleGrantedAuthority(getAuthority().name());
    }

    public static Role from(RoleType type) {
        var role = new Role();
        role.setAuthority(type);

        return role;
    }






}
