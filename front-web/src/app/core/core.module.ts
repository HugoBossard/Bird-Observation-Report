import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { UiModule } from "../ui/ui.module";
import { FooterComponent } from "./components/footer/footer.component";
import { HeaderComponent } from "./components/header/header.component";
import { NavComponent } from "./components/nav/nav.component";

@NgModule({
    declarations: [HeaderComponent, NavComponent, FooterComponent],
    imports: [CommonModule, RouterModule],
    exports: [UiModule, HeaderComponent, NavComponent, FooterComponent]
})

export class CoreModule { }