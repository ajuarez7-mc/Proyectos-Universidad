package org.LaboratorioColas;
import java.util.Comparator;
import java.util.PriorityQueue;
//" "  < >
public class ColasPrioridad {

    static class Ticket{
        int id;
        String Cliente;
        int Prioridad;
        long Timestamp;
        String Descripcion;

        public Ticket(int id, String Cliente, int Prioridad, long Timestamp, String Descripcion) {
            this.id = id;
            this.Cliente = Cliente;
            this.Prioridad = Prioridad;
            this.Timestamp = Timestamp;
            this.Descripcion = Descripcion;
        }
        @Override
        public String toString() {
            return "Ticket(id: " + id + ", Cliente: " + Cliente + ", Prioridad del ticket: " + Prioridad + ", TiempoLlegada: " + Timestamp + ", Descripción: " + Descripcion + ")";
        }
    } //fin de la clase ticket

    static class SupportCenter{
        PriorityQueue<Ticket> tickets;
        public SupportCenter(){
            Comparator<Ticket> comparador = (a,b) -> {
                if (a.Prioridad != b.Prioridad) {
                    return Integer.compare(b.Prioridad, a.Prioridad); //prioridad por Desc
                }
                    return Long.compare(a.Timestamp, b.Timestamp);//empate por timestamp asc
            };
            tickets = new PriorityQueue<>(comparador);
            };


        public void addTicket(Ticket t){
            tickets.add(t);
        }

        public Ticket NextTicket(){
            return tickets.peek();
        }
        public Ticket attendTicket(){
            return tickets.poll();
        }
        public int PendingCount(){
            return tickets.size();
        }
        public boolean isEmpty(){
            return tickets.isEmpty();
        }
    }//fin de la clase de support center


    public static void main(String[] args) {

        System.out.println("Sistema de atención de Tickets");
        System.out.println("Se atenderá a cada uno en orden de prioridad");

        SupportCenter CentroSoporte = new SupportCenter();

        CentroSoporte.addTicket(new Ticket(1, "Ana", 3, 100, "No puedo iniciar sesión"));
        CentroSoporte.addTicket(new Ticket(2, "Luis", 5, 120, "Sistema caído"));
        CentroSoporte.addTicket(new Ticket(3, "Marta", 5, 110, "Error de pagos"));
        CentroSoporte.addTicket(new Ticket(4, "Pedro", 2, 130, "Consulta general"));
        CentroSoporte.addTicket(new Ticket(5, "Sofía", 3, 90, "Cambio de contraseña"));

        System.out.println("Orden de los Tickets: ");

        while(!CentroSoporte.isEmpty()){
            System.out.println(CentroSoporte.attendTicket());
        }

        System.out.println("\nTodos los tickets han sido atendidos.");
    }
}