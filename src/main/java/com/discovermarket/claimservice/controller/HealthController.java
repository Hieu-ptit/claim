package com.discovermarket.claimservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discovermarket.core.controllers.BaseHealthController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/")
@Api(tags = {"Health Check"})
public class HealthController extends BaseHealthController {

}
