package com.PMACORESOFT.coresoft.Entidades;
import static com.PMACORESOFT.coresoft.Util.UtilBD.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name =   IOT_PMA_USUARIO )
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "No puede ser vacio.")
    @Size(min = 4, max = 30, message = "Tiene que ser mayor de 4 caracteres")
    @Column(nullable = false, length = 30)
    private String Nombre;

    @NotEmpty(message = "No puede ser vacio.")
    @Size(min = 3, max = 30, message = "Tiene que ser mayor de 3 caracteres")
    @Column(nullable = false, length = 30)
    private String ApellidoPaterno;

    @NotEmpty(message = "No puede ser vacio.")
    @Size(min = 3, max = 30, message = "Tiene que ser mayor de 3 caracteres")
    @Column(nullable = false, length = 30)
    private String ApellidoMaterno;

    @NotEmpty(message = "No puede ser vacio.")
    @Size(max = 1)
    @Column(nullable = false, length = 1)
    private String Sexo;

    @NotEmpty(message = "No puede ser vacio.")
    @Size(min = 8, max = 8, message = "Tiene que ser igual a 8 caracteres.")
    @Column(nullable = false, length = 8,unique = true)
    private String DocumentoIdentidad;

    @NotEmpty(message = "No puede ser vacio.")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String Direccion;


    @Column(length = 12, unique = true)
    private String Telefono;

    @NotEmpty(message = "No puede ser vacio.")
    @Email
    @Size(min = 12, max = 50, message = "Tiene que ser mayor de 12 caracteres")
    @Column(nullable = false, length = 50,unique = true)
    private String Email;

    @NotEmpty
    @Size(min = 8, max = 60, message = "Tiene que ser mayor de 8 caracteres")
    @Column(nullable = false, length = 60)
    private String Password;

    @NotEmpty
    private Boolean Estado;
    @NotNull(message = "No puede estar vacio")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date FechaRegistro;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "iot_pma_usuario_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns =@JoinColumn(name = "role_id") )
    private List<Rol> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getDocumentoIdentidad() {
        return DocumentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        DocumentoIdentidad = documentoIdentidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
