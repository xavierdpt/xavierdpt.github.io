package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

@Scaffolded
public class UserPrincipalLookupServiceExample extends BaseExample<UserPrincipalLookupService> {
    @Override
    public void scaffold(UserPrincipalLookupService instance) throws IOException {
        String name = null;
        UserPrincipal userPrincipal = instance.lookupPrincipalByName(name);
        GroupPrincipal groupPrincipal = instance.lookupPrincipalByGroupName(name);
    }
}
