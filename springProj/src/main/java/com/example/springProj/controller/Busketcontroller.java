package com.example.springProj.controller;

import com.example.springProj.models.Busket;
import com.example.springProj.models.Customer;
import com.example.springProj.models.Item;
import com.example.springProj.models.OrderLine;
import com.example.springProj.repo.BusketRepo;
import com.example.springProj.repo.CustomerRepo;
import com.example.springProj.repo.ItemsRepo;
import com.example.springProj.repo.OrderLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class Busketcontroller {

    @Autowired
    private OrderLineRepo orderLineRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private BusketRepo busketRepo;
    @Autowired
    private ItemsRepo itemsRepo;

    @GetMapping("/busket")
    public String busket(Principal principal, Model model){

        Customer customer=customerRepo.findByLogin(principal.getName());
        model.addAttribute("busket", customer.getBusket());

        return "busket";
    }

    @PostMapping("/addToBusket")
    public String addToBusket(@RequestParam long itemId,Principal principal, Model model){

        Item item = itemsRepo.findById(Long.valueOf(itemId).longValue()).orElseThrow(IllegalStateException::new);

        Customer customer=customerRepo.findByLogin(principal.getName());
        OrderLine orderLine= orderLineRepo.findByItem(item);

        if(customer.getBusket().getOrderLine().contains(orderLine)){
            int index=customer.getBusket().getOrderLine().indexOf(orderLine);
            orderLine = customer.getBusket().getOrderLine().get(index);
            orderLine.setCount(orderLine.getCount()+1);
            customer.getBusket().getOrderLine().set(index,orderLine);

        }
        else {
            customer.getBusket().getOrderLine().add(new OrderLine(item,1,customer.getBusket()));
        }
            customerRepo.save(customer);
        return "redirect:items";
    }

    @PostMapping("/delItemFromBusket")
    public String delItemFromBusket(@RequestParam long orderLineId, Model model){

        OrderLine orderLine= orderLineRepo.findById(orderLineId).orElseThrow(IllegalStateException::new);

        if(orderLine.getCount()>1){
            orderLine.setCount(orderLine.getCount()-1);
            orderLineRepo.save(orderLine);
        }
        else {
            orderLineRepo.deleteById(orderLineId);
        }
        return "redirect:busket";
    }
}
