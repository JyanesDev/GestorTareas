package logica;


import java.time.LocalDate;
import logica.EstadoTarea;
import logica.Prioridad;
import logica.Tarea;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("Tarea")
public class TareaTest {
    
    // ----------------- CONSTRUCTOR CON PARÁMETROS ---------------------------
    @Nested
    @DisplayName("Constructor con parámetros")
    class ConstuctorConParametros{
        @Test
        @DisplayName("asigna el título correctamente")
        void asignaTitulo(){
            Tarea tarea = new Tarea("Estudiante Java", "Capítulo 1 al 5", Prioridad.ALTA, LocalDate.of(2026, 6, 07));
            
            // Assert
            assertEquals("Estudiante Java", tarea.getTitulo());
        }
        
        @Test
        @DisplayName("asigna la prioridad indicada")
        void asignarPrioridad(){
            Tarea tarea = new Tarea ("Tarea", null, Prioridad.ALTA, null);
            
            assertEquals(Prioridad.ALTA, tarea.getPrioridad());
        }
        
        @Test
        @DisplayName("asigna prioridad MEDIA por defecto si se pasa NULL")
        void prioridadDefaultMedia(){
            Tarea tarea = new Tarea ("Tarea", null, null, null);
            
            assertEquals(Prioridad.MEDIA, tarea.getPrioridad(), "Si la prioridad es null debe asignarse MEDIA por defecto");
        }
        
        @Test
        @DisplayName("el estado inicial siempre es PENDIENTE (RN-05)")
        void estadoInicialPendiente(){
            Tarea tarea = new Tarea ("Tarea", null, Prioridad.BAJA, null);
            
            assertEquals(EstadoTarea.PENDIENTE, tarea.getEstado(), "Una tarea siempre empieza PENDIENTE" );
        }
        
        @Test
        @DisplayName("la fecha de creación de asigna automáticamente")
        void fechaCreacionNoNull(){
            Tarea tarea = new Tarea ("Tarea",null, Prioridad.MEDIA, null);
            
            assertNotNull(tarea.getFechaCreacion(), "La fecha de creación debe asignarse automáticamente al construirse");
            
        }
        
        @Test
        @DisplayName("La fecha de modificación es null al crear")
        void fechaModificacionEsNullAlCrear(){
            Tarea tarea = new Tarea ("Tarea",null, Prioridad.MEDIA, null);
            
            assertNull(tarea.getFechaModificacion(),"Una tarea recién creaada no ha sido modificada todavía");
        }
        
        @Test
        @DisplayName("el id es null antes de persistir")
        void idEsNullAntesDePersistir(){
            Tarea tarea = new Tarea ("Tarea",null, Prioridad.MEDIA, null);
            
            assertNull(tarea.getId(), "El id debe de ser null antes de asignarlo (BD o repositorio)");
        }
        
        @Test
        @DisplayName("asigna fecha límite correctamente")
        void asignaFechaLimite(){
            LocalDate limite = LocalDate.of(2026, 12, 31);
            Tarea tarea = new Tarea ("Tarea",null, Prioridad.MEDIA, limite);
            
            assertEquals(limite, tarea.getFechaLimite());
        }
        
        @Test
        @DisplayName("asigna descripción correctamente")
        void asingaDescripcion(){
            Tarea tarea = new Tarea ("Tarea","Descripción detallada", Prioridad.MEDIA, null);
            
            assertEquals("Descripción detallada", tarea.getDescripcion() );
        }
    }
    
    // ----------------- CONSTRUCTOR VACÍO ---------------------------
        @Nested
        @DisplayName("Constructor Vacío")
    class ConstructorVacio{
        
       @Test
       @DisplayName("se puede instaciar sin parámetros")
       void instanciarSinParametros(){
           Tarea tarea = new Tarea ();
           
           assertNotNull(tarea, "El constructor vacío debe crear un objeto no null");
       }
       
       @Test
       @DisplayName("todos los atributos son null por defecto")
       void atributosNullPorDefecto(){
           Tarea tarea = new Tarea ();
           
            assertAll("atributos del constructor vacío", 
                () -> assertNull(tarea.getId()),
                () -> assertNull(tarea.getTitulo()),
                () -> assertNull(tarea.getDescripcion()),
                () -> assertNull(tarea.getPrioridad()),
                () -> assertNull(tarea.getEstado()),
                () -> assertNull(tarea.getFechaLimite()),
                () -> assertNull(tarea.getFechaCreacion()),
                () -> assertNull(tarea.getFechaModificacion())
            );
        }            
    }
        
    // ----------------- Equals() y hashCode() ---------------------------
        @Nested
        @DisplayName("equals y hashcode")
        class EqualsYHashCode{
            @Test
            @DisplayName("dos tareas con el mismo id son iguales")
            void igualConMismoId(){
                Tarea t1 = new Tarea("Tarea A", null, Prioridad.ALTA, null);
                t1.setId(1L);
                
                Tarea t2 = new Tarea("Tarea B", null, Prioridad.BAJA, null);
                t2.setId(1L);
                
                assertEquals(t1,t2, " Mismo id = misma entidad, aunque tengan datos diferentes");
            }
            
            @Test
            @DisplayName("dos tareas con id diferente NO son iguales")
            void distintoConIdDiferente(){
                Tarea t1 = new Tarea("Misma tarea", null, Prioridad.ALTA, null);
                t1.setId(1L);
                
                Tarea t2 = new Tarea("Misma tarea", null, Prioridad.ALTA, null);
                t2.setId(2L);
                
                assertNotEquals(t1,t2,"Diferente id = diferente entidad, aunque tengan los mismos datos");
            }
            
            @Test
            @DisplayName("dos tareas con id NULL NO son iguales")
            void noIgualesConIdNull(){
                Tarea t1 = new Tarea("Tarea", null, Prioridad.ALTA,  null);
                Tarea t2 = new Tarea("Tarea", null, Prioridad.ALTA,  null);
                // Ambas tienen id = null (no persistidas)

                assertNotEquals(t1,t2,"Dos tareas no persistidas(id=null), no deben considerse iguales");
                
            }
            
            @Test
            @DisplayName("una tarea es igual a si misma")
            void igualASiMisma(){
                Tarea tarea = new Tarea("Tarea", null, Prioridad.ALTA,  null);
                
                assertEquals(tarea, tarea, "Reflexibilidad: un objeto es igual a sí mismo");
            }
            
            @Test
            @DisplayName("una tarea no es igual a NULL")
            void noIgualNull(){
                Tarea tarea = new Tarea("Tarea", null, Prioridad.ALTA,  null);
                
                assertNotEquals(null, tarea, "ningún objeto es igual a NULL");
            }
            
            @Test
            @DisplayName("una tarea no es igual a otro tipo de objeto")
            void noIgualAOtrotipo(){
                Tarea tarea = new Tarea("Tarea", null, Prioridad.ALTA,  null);
                
                assertNotEquals("un String", tarea, "Una tarea no es igual a un String");
            }
        }
        
        // ----------------- toString() ---------------------------
        @Nested
        @DisplayName("toString")
        class ToStringTest{
            @Test
            @DisplayName("incluye el título y el estado")
            void incluyeinformacionRelevante(){
                Tarea tarea = new Tarea("Estudiar Java", null, Prioridad.ALTA,  null);
                tarea.setId(42L);
                
                String texto = tarea.toString();
                        
                assertAll("toString contiene ingo relevante",
                    () -> assertTrue(texto.contains("42"), "Debe incluir el id"),
                    () -> assertTrue(texto.contains("Estudiar Java"), "Debe incluir el título"),
                    () -> assertTrue(texto.contains("ALTA"), "Debe incluir la prioridad"),
                    () -> assertTrue(texto.contains("PENDIENTE"), "Debe incluir el estado")
                );
            }
        }
        
        // ----------------- marcarModificada() ---------------------------
        @Nested
        @DisplayName("marcarModificada")
        class MarcarModificada{
        
            @Test
            @DisplayName("actualiza la fecha de modificación")
            void actualizarFechaModificacion(){
                Tarea tarea = new Tarea("Estudiar Java", null, Prioridad.MEDIA,  null);
                assertNull(tarea.getFechaModificacion(), "Precondicion: null al crear ");
                
                tarea.marcarModificado();
                
                assertNotNull(tarea.getFechaModificacion(), "Después de marcarModificada(), la fecha no debe de ser null");
            }
        }
        
        
   
}
