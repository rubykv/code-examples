package com.example.archunitdemo;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


public class ArchUnitDemoApplicationTests {

    private static JavaClasses classes;

    @BeforeAll
    public static void setup() {
        classes = new ClassFileImporter().importPackages("com.example.archunitdemo");
    }

    @Test
    public void testRepositoryOnlyAccessedByService() {
        ArchRule servicePackageRule = classes()
                .that().resideInAPackage("..repository..")
                .should().onlyBeAccessed()
                .byAnyPackage("..service..");
        servicePackageRule.check(classes);
    }

    @Test
    public void testRepositoryClassResidesInRepositoryPackage() {
        ArchRule servicePackageRule = classes()
                .that().haveNameMatching(".*Repository")
                .should().resideInAPackage("..repository..");
        servicePackageRule.check(classes);
    }

    @Test
    public void testServiceShouldNotCallController() {
        ArchRule servicePackageRule = noClasses().that().resideInAPackage("..service..")
                .should().accessClassesThat().resideInAPackage("..controller..");
        servicePackageRule.check(classes);
    }

    @Test
    public void testLayerDependenciesAreFollowed() {
        ArchRule layerDependencyRule = layeredArchitecture().consideringAllDependencies()

                .layer("Controllers").definedBy("com.example.archunitdemo.controller..")
                .layer("Services").definedBy("com.example.archunitdemo.service..")
                .layer("Repositories").definedBy("com.example.archunitdemo.repository..")

                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
                .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Services");
        layerDependencyRule.check(classes);
    }

    @Test
    public void testServiceClassNames() {
        ArchRule servicesNamingRule = classes()
                .that().resideInAPackage("..service..")
                .and().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("Service");
        servicesNamingRule.check(classes);
    }
}
