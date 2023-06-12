package ru.bratusev.myapplication.models;

/**
 * Класс Вкладыш
 * Хранит инфомрацию о дате выдач книги, сроке и номер читательского
 * Реализует гетеры и сетеры для полей
 */
public class BookInsert {
    private String date; // Дата выдачи книги
    private String deadline; // Срок выдачи книги
    private String ticketNumber; // Номер читательского билета

    public BookInsert(BookInsertBuilder builder) {
        date = builder.date;
        deadline = builder.deadline;
        ticketNumber = builder.ticketNumber;
    }

    @Override
    public String toString() {
        return "{" + date + " " + deadline + " " + ticketNumber + "}";
    }

    public static class BookInsertBuilder {
        private String date; // Дата выдачи книги
        private String deadline; // Срок выдачи книги
        private String ticketNumber; // Номер читательского билета

        public BookInsertBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public BookInsertBuilder setDeadline(String deadline) {
            this.deadline = deadline;
            return this;
        }

        public BookInsertBuilder setTicketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public BookInsert build() {
            return new BookInsert(this);
        }

    }
}
