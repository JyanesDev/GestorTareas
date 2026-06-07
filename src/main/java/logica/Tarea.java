
package logica;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Tarea {
    
    private Long id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private EstadoTarea estado;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaLimite;
    private LocalDateTime fechaModificacion;

    // -------------------------- CONSTRUCTORES -------------------------------------------------
    public Tarea() {
    }

    public Tarea(String titulo, String descripcion, Prioridad prioridad, LocalDate fechaLimite) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = (prioridad != null) ? prioridad: Prioridad.BAJA;
        this.fechaLimite = fechaLimite;
        this.fechaModificacion = fechaModificacion;
        
        if (prioridad == null) {
            this.prioridad = Prioridad.MEDIA;
        } else {
            this.prioridad = prioridad;
        }
        
        // Le asigno directamente porque no lo paso por parámetro
        this.estado = estado.PENDIENTE;
        
        this.fechaCreacion = LocalDateTime.now();
        
    }
    
    // -------------------------- GETTERS -------------------------------------------------

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public Prioridad getPrioridad() { return prioridad; }
    public EstadoTarea getEstado() { return estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDate getFechaLimite() { return fechaLimite; }
    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    
    // -------------------------- SETTERS -------------------------------------------------

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrioridad(Prioridad prioridad) { this.prioridad = prioridad; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }
    
    public void setEstados(EstadoTarea estado){
        this.estado = estado;
    }
    public void marcarModificado(){
        this.fechaModificacion = LocalDateTime.now();
    }
    // -------------------------- MÉTODOS equals y hasCode -------------------------------------------------

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj == null || getClass() != obj.getClass()) return false;
       Tarea otra = (Tarea) obj;
       return id != null && id.equals(otra.id);
    }
    
    
    // -------------------------- TO STRING -------------------------------------------------

    @Override
    public String toString() {
        return "Tarea{" +
                    "id=" + id +
                    ", titulo='" + titulo + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", prioridad=" + prioridad +
                    ", estado=" + estado +
                    ", fechaLimite=" + fechaLimite +
                '}';
    }
    
}
