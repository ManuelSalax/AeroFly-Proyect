package com.proyect.proyect_aerofly.Infrastructure.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyect.proyect_aerofly.Application.UseCase.CancelarReservaService;
import com.proyect.proyect_aerofly.Application.UseCase.CancelarReservaUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.CrearReservaService;
import com.proyect.proyect_aerofly.Application.UseCase.CrearReservaUseCase;
import com.proyect.proyect_aerofly.Domain.Repository.BuscarClienteService;
import com.proyect.proyect_aerofly.Domain.Repository.BuscarClienteUseCase;
import com.proyect.proyect_aerofly.Domain.Repository.BuscarViajesPorDestinoService;
import com.proyect.proyect_aerofly.Domain.Repository.BuscarViajesPorDestinoUseCase;
import com.proyect.proyect_aerofly.Domain.Repository.ClienteRepository;
import com.proyect.proyect_aerofly.Domain.Repository.ListarViajesService;
import com.proyect.proyect_aerofly.Domain.Repository.ListarViajesUseCase;
import com.proyect.proyect_aerofly.Domain.Repository.PagoRepository;
import com.proyect.proyect_aerofly.Domain.Repository.RegistrarClienteService;
import com.proyect.proyect_aerofly.Domain.Repository.RegistrarClienteUseCase;
import com.proyect.proyect_aerofly.Domain.Repository.RegistrarPagoService;
import com.proyect.proyect_aerofly.Domain.Repository.RegistrarPagoUseCase;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;
import com.proyect.proyect_aerofly.Domain.Repository.ViajeRepository;

@Configuration
public class UseCaseConfig {

    // ---------- RESERVAS ----------

    @Bean
    public CrearReservaUseCase crearReservaUseCase(
            ClienteRepository clienteRepository,
            ViajeRepository viajeRepository,
            ReservaRepository reservaRepository
    ) {
        return new CrearReservaService(clienteRepository, viajeRepository, reservaRepository);
    }

    @Bean
    public CancelarReservaUseCase cancelarReservaUseCase(ReservaRepository reservaRepository) {
        return new CancelarReservaService(reservaRepository);
    }

    // ---------- CLIENTES ----------

    @Bean
    public RegistrarClienteUseCase registrarClienteUseCase(ClienteRepository clienteRepository) {
        return new RegistrarClienteService(clienteRepository);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClienteRepository clienteRepository) {
        return new BuscarClienteService(clienteRepository);
    }

    // ---------- VIAJES ----------

    @Bean
    public ListarViajesUseCase listarViajesUseCase(ViajeRepository viajeRepository) {
        return new ListarViajesService(viajeRepository);
    }

    @Bean
    public BuscarViajesPorDestinoUseCase buscarViajesPorDestinoUseCase(ViajeRepository viajeRepository) {
        return new BuscarViajesPorDestinoService(viajeRepository);
    }

    // ---------- PAGOS ----------

    @Bean
    public RegistrarPagoUseCase registrarPagoUseCase(
            ReservaRepository reservaRepository,
            PagoRepository pagoRepository
    ) {
        return new RegistrarPagoService(reservaRepository, pagoRepository);
    }

    // ---------- USUARIOS ----------

    // No hay un caso de uso aún, pero puedes agregar aquí luego:
    // @Bean
    // public LoginUseCase loginUseCase(UsuarioRepository usuarioRepository) {
    //     return new LoginService(usuarioRepository);
    // }
}
