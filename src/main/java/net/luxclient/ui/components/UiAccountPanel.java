package net.luxclient.ui.components;

import net.luxclient.LuxClient;
import net.luxclient.ui.UiComponent;
import net.luxclient.util.ClientGuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;

import java.awt.*;

public class UiAccountPanel extends UiComponent {

    private Session account;

    private int hoverFade = 0;

    public UiAccountPanel(int x, int y, Session session) {
        super(x, y, (int) LuxClient.Fonts.text.getWidth(Minecraft.getMinecraft().getSession().getUsername()) + 26, 20);
        this.account = session;
    }

    @Override
    public void renderComponent(int mouseX, int mouseY, boolean ingame) {
        if(isHovered(mouseX, mouseY)) {
            if(hoverFade < 25) hoverFade += 5;

        } else {
            if(hoverFade > 0) hoverFade -= 5;

        }

        Color c = new Color(255, 255, 255, 26 + hoverFade);

        ClientGuiUtils.drawRoundedRect(this.x, this.y, this.width, this.height, 4, c);
        ClientGuiUtils.drawRoundedRect(this.x + 1, this.y + 1, 18, 18, 3, c);

        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("lux/steve.png"));
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        Gui.drawModalRectWithCustomSizedTexture(this.x + 3, this.y + 3, 0, 0, 14, 14, 14, 14);

        LuxClient.Fonts.text.drawCenteredString(this.account.getUsername(), this.x + 40, this.y + 5, -1);
    }

}
