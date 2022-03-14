package com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.SingleTable;
import com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.SingleTable.Check;
import com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.SingleTable.CreditCard;
import com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.SingleTable.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class PaymentTest {
    @Autowired
    PaymentRepository paymentRepository;
    @Test
    public void createPayment()
    {
        CreditCard cc=new CreditCard();
        cc.setId(1234);
        cc.setAmount(40000);
        cc.setCardnumber("1345678");
        paymentRepository.save(cc);
    }
    @Test
    public void createCheckPayment()
    {
        Check ch=new Check();
        ch.setId(111);
        ch.setAmount(120);
        ch.setChecknumber("80999");
        paymentRepository.save(ch);
    }


}