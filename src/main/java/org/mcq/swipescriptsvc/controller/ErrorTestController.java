package org.mcq.swipescriptsvc.controller;

import org.mcq.swipescriptsvc.error.NotFoundException;
import org.mcq.swipescriptsvc.error.temp.BadRequestException;
import org.mcq.swipescriptsvc.error.temp.UnauthorizedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/buggy/")
public class ErrorTestController {

    @GetMapping("not-found")
    public void notFoundError() {
        throw new NotFoundException("testing not found error!");
    }

    @GetMapping("bad-request")
    public void badRequestError() {
        throw new BadRequestException("Testing bad request error!");
    }

    @GetMapping("server-error")
    public void serverError() {
        throw new RuntimeException("Testing internal server error!");
    }

    @GetMapping("auth")
    public void authError() {
        throw new UnauthorizedException("Testing unauthorized error!");
    }
}
