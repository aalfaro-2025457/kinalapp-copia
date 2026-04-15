package com.angelalfaro.kinalapp.controller;

import com.angelalfaro.kinalapp.entity.Client;
import com.angelalfaro.kinalapp.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/view/clients")
public class ClientWebController {

    private final ClientService clientService;

    @GetMapping
    public String getClients(Model model){

        List<Client> clients = clientService.listAll();
        model.addAttribute("clients", clients);
        model.addAttribute("newClient", new Client());
        return "cruds/clients";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("newClient") Client client) {
        clientService.save(client);
        return "redirect:/view/clients";
    }

}
