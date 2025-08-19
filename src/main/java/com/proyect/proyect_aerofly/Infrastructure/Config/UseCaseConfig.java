package com.proyect.proyect_aerofly.Infrastructure.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.proyect.proyect_aerofly.Application.Services.BuscarClienteService;
import com.proyect.proyect_aerofly.Application.Services.BuscarViajesPorDestinoService;
import com.proyect.proyect_aerofly.Application.Services.CancelarReservaService;
import com.proyect.proyect_aerofly.Application.Services.CrearReservaService;
import com.proyect.proyect_aerofly.Application.Services.ListarPagosService;
import com.proyect.proyect_aerofly.Application.Services.ListarUsuariosService;
import com.proyect.proyect_aerofly.Application.Services.ListarViajesService;
import com.proyect.proyect_aerofly.Application.Services.RegistrarClienteService;
import com.proyect.proyect_aerofly.Application.Services.RegistrarUsuarioService;
import com.proyect.proyect_aerofly.Application.UseCase.BuscarClienteUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.BuscarViajesPorDestinoUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.CancelarReservaUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.CrearReservaUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.ListarPagosUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.ListarUsuariosUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.ListarViajesUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.RegistrarClienteUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.RegistrarPagoUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.RegistrarPagoUseCaseImpl;
import com.proyect.proyect_aerofly.Application.UseCase.RegistrarUsuarioUseCase;
import com.proyect.proyect_aerofly.Domain.Repository.ClienteRepository;
import com.proyect.proyect_aerofly.Domain.Repository.PagoRepository;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;
import com.proyect.proyect_aerofly.Domain.Repository.UsuarioRepository;
import com.proyect.proyect_aerofly.Domain.Repository.ViajeRepository;

@Configuration
public class UseCaseConfig {

    // ---------- RESERVAS ----------



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
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(
        @Qualifier("usuarioJpaAdapter") UsuarioRepository usuarioRepository) {
        return new RegistrarUsuarioService(usuarioRepository);
    }
    @Bean
    public RegistrarPagoUseCase registrarPagoUseCase(
            @Qualifier("reservaJpaAdapter") ReservaRepository reservaRepository,
            PagoRepository pagoRepository) {

        return new RegistrarPagoUseCaseImpl(reservaRepository, pagoRepository);
    }
    @Bean
    public CrearReservaUseCase crearReservaUseCase(
        ClienteRepository clienteRepository,
        @Qualifier("vueloJpaAdapter") ViajeRepository viajeRepository,
        ReservaRepository reservaRepository
    ) {
        return new CrearReservaService(clienteRepository, viajeRepository, reservaRepository);
    }
    @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOrigins("http://localhost:5173")
                            .allowedMethods("GET", "POST", "PUT", "DELETE");
                }
            };
        }

    @Bean
    public ListarUsuariosUseCase listarUsuariosUseCase(
        @Qualifier("usuarioJpaAdapter") UsuarioRepository usuarioRepository) {
        return new ListarUsuariosService(usuarioRepository);
    }
    @Bean
    public ListarPagosUseCase listarPagosUseCase(PagoRepository pagoRepository) {
        return new ListarPagosService(pagoRepository);
    }




}

    // ---------- USUARIOS ----------

    // No hay un caso de uso aún, pero puedes agregar aquí luego:
    // @Bean
    // public LoginUseCase loginUseCase(UsuarioRepository usuarioRepository) {
    //     return new LoginService(usuarioRepository);
    // }

