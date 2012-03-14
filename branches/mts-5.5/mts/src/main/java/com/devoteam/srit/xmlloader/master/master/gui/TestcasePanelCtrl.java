/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devoteam.srit.xmlloader.master.master.gui;

import com.devoteam.srit.xmlloader.core.Testcase;
import com.devoteam.srit.xmlloader.master.master.utils.ControlerTest;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Gwenhael
 */
public class TestcasePanelCtrl {
    private TestcasePanelView _view;
    private ControlerTest _controlerTest;
    private LinkedList<TestcaseLineCtrl> _jPanelTestcaseLineCtrls;
    private boolean _disposed;
    
    public TestcasePanelCtrl(TestcasePanelView view, ControlerTest controlerTest) {
        _view = view;
        _disposed = false;
        _controlerTest = controlerTest;
        _jPanelTestcaseLineCtrls = new LinkedList<TestcaseLineCtrl>();

        int i = 0;
        // create and add a TestcaseLineView/Ctrl per testcase
        for (Testcase testcase : controlerTest.getTest().getChildren()) {
            TestcaseLineView jPanelTestcaseLineView = new TestcaseLineView();
            TestcaseLineCtrl jPanelTestcaseLineCtrl = new TestcaseLineCtrl(jPanelTestcaseLineView, testcase);

            _jPanelTestcaseLineCtrls.add(jPanelTestcaseLineCtrl);
            _controlerTest.registerToCache(testcase.getName(), jPanelTestcaseLineCtrl);

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridy = i;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 1;


            _view.add(jPanelTestcaseLineView, constraints);

            if (i % 2 == 0) {
                jPanelTestcaseLineView.setBackground(jPanelTestcaseLineView.getBackground().brighter());
            }

            i++;
        }

        // create the panel for vertical padding
        JPanel jPanelPadding = new JPanel();
        jPanelPadding.setMinimumSize(new Dimension(0, 0));
        jPanelPadding.setPreferredSize(new Dimension(0, 0));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = i;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weighty = 1;
        _view.add(jPanelPadding, constraints);
    }

    public TestcasePanelView getView() {
        return _view;
    }

    public void dispose() {
        _disposed = true;
        for (TestcaseLineCtrl jPanelTestcaseLineCtrl : _jPanelTestcaseLineCtrls) {
            _controlerTest.unregisterFromCache(jPanelTestcaseLineCtrl.getTestcase().getName(), jPanelTestcaseLineCtrl);
        }
        _view.removeAll();
        _jPanelTestcaseLineCtrls.clear();
    }
    
    public boolean disposed() {
        return _disposed;
    }
    
}
