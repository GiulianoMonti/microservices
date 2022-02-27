//package com.g.customer;
//
//public class CustomerService {
//
//    private final CustomerRepository customerRepository;
//    private final FraudClient fraudClient;
//    private final RabbitMQMessageProducer rabbitMQMessageProducer;
//
//    public void registerCustomer(CustomerRegistrationRequest request) {
//        Customer customer = Customer.builder()
//                .firstName(request.firstName())
//                .lastName(request.lastName())
//                .email(request.email())
//                .build();
//        // todo: check if email valid
//        // todo: check if email not taken
//        customerRepository.saveAndFlush(customer);
//
//        FraudCheckResponse fraudCheckResponse =
//                fraudClient.isFraudster(customer.getId());
//
//        if (fraudCheckResponse.isFraudster()) {
//            throw new IllegalStateException("fraudster");
//        }
//
//        NotificationRequest notificationRequest = new NotificationRequest(
//                customer.getId(),
//                customer.getEmail(),
//                String.format("Hi %s, welcome to Amigoscode...",
//                        customer.getFirstName())
//        );
//        rabbitMQMessageProducer.publish(
//                notificationRequest,
//                "internal.exchange",
//                "internal.notification.routing-key"
//        );
//
//    }
//}