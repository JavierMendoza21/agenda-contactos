package com.agenda.contactos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import com.agenda.contactos.Modelo.Contacto;
import com.agenda.contactos.repositorio.ContactoRepositorio;

@Controller
public class ContactoControlador {

	@Autowired
	private ContactoRepositorio contactoRepositorio;

	@GetMapping({ "/", "" })
	public String verPaguinaDeInicio(Model modelo) {
		List<Contacto> contactos = contactoRepositorio.findAll();
		modelo.addAttribute("contactos", contactos);
		return "index";
	}

	@GetMapping("/nuevo")
	public String agregarContacto(Model modelo) {
		modelo.addAttribute("contacto", new Contacto());
		return "nuevo";
	}

	@PostMapping("/nuevo")
	public String guardarContacto(@Validated Contacto contacto, BindingResult bindingResult,
			RedirectAttributes redirect, Model modelo) {
		if (bindingResult.hasErrors()) {
			modelo.addAttribute("contacto", contacto);
						
			return "nuevo";
		}
		contactoRepositorio.save(contacto);
		redirect.addFlashAttribute("msgExito", "El contacto ah sido agregado con exito");
		return "redirect:/";
	}
}
