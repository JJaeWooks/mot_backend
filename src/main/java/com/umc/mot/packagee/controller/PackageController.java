package com.umc.mot.packagee.controller;

import com.umc.mot.packagee.dto.PackageRequestDto;
import com.umc.mot.packagee.dto.PackageResponseDto;
import com.umc.mot.packagee.entity.Package;
import com.umc.mot.packagee.mapper.PackageMapper;
import com.umc.mot.packagee.service.PackageService;
import com.umc.mot.sellMember.dto.SellMemberRequestDto;
import com.umc.mot.sellMember.dto.SellMemberResponseDto;
import com.umc.mot.sellMember.entity.SellMember;
import com.umc.mot.sellMember.mapper.SellMemberMapper;
import com.umc.mot.sellMember.service.SellMemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;



@RestController
@RequestMapping("/package")
@Validated
@AllArgsConstructor
public class PackageController {

    private final PackageService packageService;
    private final PackageMapper packageMapper;

    // Create
    @PostMapping
    public ResponseEntity postPackage(@Valid @RequestBody PackageRequestDto.Post post) {
        Package pa= packageService.createPackage(packageMapper.PackageRequestDtoPostToPackage(post));
        PackageResponseDto.Response response = packageMapper.PackageToPackageResponseDto(pa);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Read
    @GetMapping
    public ResponseEntity getPackage(@Positive @RequestParam int packageId) {
        Package pa = packageService.findPackage(packageId);
        PackageResponseDto.Response response = packageMapper.PackageToPackageResponseDto(pa);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Update
    @PatchMapping("/{package-id}")
    public ResponseEntity patchPackage(@Positive @PathVariable("package-id") int packageId,
                                      @RequestBody PackageRequestDto.Patch patch) {

        patch.setId(packageId);
        Package pa = packageService.patchPackage(packageMapper.PackageRequestDtoPatchToPackage(patch));
        PackageResponseDto.Response response=packageMapper.PackageToPackageResponseDto(pa);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // Delete
    @DeleteMapping("/{package-id}")
    public ResponseEntity deleteMember(@Positive @PathVariable("package-id") int packageId) {
        packageService.deletePackage(packageId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

